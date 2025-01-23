package my.rfp.ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import my.rfp.ai.dto.entity.Content;

public class MessageResponseDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("role")
    private String role;

    @JsonProperty("content")
    private List<Content> content;

    @JsonProperty("fileIds")
    private List<String> fileIds;

    @JsonProperty("assistantId")
    private String assistantId;

    @JsonProperty("runId")
    private String runId;

    @JsonProperty("metadata")
    private Object metadata;

   
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Content> getContent() {
		return content;
	}


	public void setContent(List<Content> content) {
		this.content = content;
	}


	public List<String> getFileIds() {
		return fileIds;
	}


	public void setFileIds(List<String> fileIds) {
		this.fileIds = fileIds;
	}


	public String getAssistantId() {
		return assistantId;
	}


	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}


	public String getRunId() {
		return runId;
	}


	public void setRunId(String runId) {
		this.runId = runId;
	}


	public Object getMetadata() {
		return metadata;
	}


	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}


	@Override
    public String toString() {
        return "MessageResponseDTO{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", content=" + content +
                ", fileIds=" + fileIds +
                ", assistantId='" + assistantId + '\'' +
                ", runId='" + runId + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}



