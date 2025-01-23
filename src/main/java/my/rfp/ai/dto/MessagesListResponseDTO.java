package my.rfp.ai.dto;

import java.util.List;

public class MessagesListResponseDTO {
    private List<MessageResponseDTO> data;

    public List<MessageResponseDTO> getData() {
        return data;
    }

    public void setData(List<MessageResponseDTO> data) {
        this.data = data;
    }
}

