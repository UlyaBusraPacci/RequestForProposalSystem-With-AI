package my.rfp.ai.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RunResponseDTO(
        String id,
        String object,
        @JsonProperty("created_at") long createdAt,
        @JsonProperty("assistant_id") String assistantId,
        @JsonProperty("thread_id") String threadId,
        String status,
        @JsonProperty("started_at") Long startedAt,
        @JsonProperty("expires_at") Long expiresAt,
        @JsonProperty("cancelled_at") Long cancelledAt,
        @JsonProperty("failed_at") Long failedAt,
        @JsonProperty("completed_at") Long completedAt,
        @JsonProperty("last_error") JsonNode lastError,
        String model,
        String instructions,
        @JsonDeserialize(using = ToolsDeserializer.class)
        List<String> tools,
        @JsonProperty("file_ids") List<String> fileIds,
        Map<String, Object> metadata) {

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

}

