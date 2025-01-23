package my.rfp.ai;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import my.rfp.ai.aiController.AssistantAIClientController;
import my.rfp.ai.dto.MessageResponseDTO;
import my.rfp.ai.dto.MessagesListResponseDTO;
import my.rfp.ai.dto.RunResponseDTO;
import my.rfp.ai.dto.ThreadResponseDTO;
import my.rfp.ai.dto.entity.Content;
import my.rfp.ai.dto.entity.Text;
import my.rfp.business.abstracts.RfpItemService;
import my.rfp.business.requests.CreateRfpItemRequest;
import my.rfp.entities.rfpMain.RfpItem;

@Component
public class AiMain {
	private RfpItemService rfpItemService;
	private ModelMapper modelMapper;
	
	@Autowired
	public AiMain(RfpItemService rfpItemService, ModelMapper modelMapper) {
		super();
		this.rfpItemService = rfpItemService;
		this.modelMapper = modelMapper;
	}

	public void checkIfResponseExists(String details,  CreateRfpItemRequest createRfpItemRequest) {
		
		System.out.println("hermes2"+createRfpItemRequest);

        Properties properties = new Properties();
        long DELAY = 10; 
        properties.setProperty(details, details);

        try (InputStream input = AiMain.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }
            properties.load(input);

            AssistantAIClientController client = new AssistantAIClientController(properties);
            String assistant = client.createAssistant();
            String thread = client.createThread();
            client.sendMessage(thread, "user", details);
            RunResponseDTO run = client.runMessage(thread, assistant);

            System.out.println("thread: " + thread);
            MessagesListResponseDTO allResponses = client.getMessages(thread);
            System.out.println("These are all the messages and you will be billed by OpenAI for every single one of them:");

            log(client, thread, allResponses, createRfpItemRequest, DELAY);
            

        } catch (Exception ex) {
        	System.out.println("Exception ex" + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    private void log(AssistantAIClientController client, String thread, MessagesListResponseDTO messages, CreateRfpItemRequest createRfpItemRequest, long DELAY) throws InterruptedException{
        List<MessageResponseDTO> messagesData = messages.getData();
        int size = messagesData.size();
        
        System.out.println("----------------------------------------------------------");

        if (messagesData != null && !messagesData.isEmpty()) {

            System.out.println("Total messages: " + size);

            for (int i = size - 1; i > -1; i--) {
                MessageResponseDTO message = messagesData.get(i);
                System.out.println("Message ID: " + message.getId());
                System.out.println("Role: " + message.getRole());
                for (Content content : message.getContent()) {
                    if (content.getText() != null) {
                        System.out.println("Text Value: " + content.getText().getValue());
                    } else {
                        System.out.println("Text content is null");
                    }
                }
                System.out.println("***********************************************");
                System.out.println(""); 
            }
           
            MessageResponseDTO last = messagesData.get(0);
            List<Content> lastContent = last.getContent();

                Content lastContentItem = lastContent.get(lastContent.size() - 1);
                String value = lastContentItem.getText().getValue();
                System.out.println(value); 

           
           if ("NO".equals(value)) {
               throw new RuntimeException("WE DO NOT HAVE THE SAME question !");
           }
           else {

               createRfpItemRequest.setResponse(value);
           }
           }
           
        
                
        else {
            System.out.println("No messages found.");
        }
        
    }
    

    private void superviseWorkInProgress(AssistantAIClientController client, String threadId) {
        try {
            System.out.println("Checking messages to supervise assistant's work");
            MessagesListResponseDTO messages = client.getMessages(threadId);
            log(client, threadId, messages, null, 50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private boolean isRunDone(AssistantAIClientController client, String threadId, String runId) {
        RunResponseDTO status;
        try {
            status = client.getRunStatus(threadId, runId);
            System.out.println("Status of your run is currently " + status);
            return isRunStateFinal(status);
        } catch (Exception e) {
            System.err.println("Failed to get run state, will retry..." + e);
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isRunStateFinal(RunResponseDTO runResponseDTO) {
        List<String> finalStates = List.of("cancelled", "failed", "completed", "expired"); // I consider these states as final
        String runStatus = Optional.of(runResponseDTO).map(RunResponseDTO::status).orElse("unknown").toLowerCase();
        return finalStates.contains(runStatus);
    }
}

