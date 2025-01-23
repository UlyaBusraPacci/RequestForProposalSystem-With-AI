package my.rfp.ai.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {
    @JsonProperty("value")
    private String value;


    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
    public String toString() {
        return "Text{" +
                "value='" + value + '\'' +
                '}';
    }
}
