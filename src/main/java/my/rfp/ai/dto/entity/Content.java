package my.rfp.ai.dto.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    @JsonProperty("type")
    private String type;

    @JsonProperty("text")
    private Text text;


    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	@Override
    public String toString() {
        return "Content{" +
                "type='" + type + '\'' +
                ", text=" + text +
                '}';
    }
}