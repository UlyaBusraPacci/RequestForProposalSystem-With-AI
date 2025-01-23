//the aim of third of rfp project is multiple assistant(text file), threads, one db
//I mean the the aim is , when you add new item into db , then your assistant has to be update your text file
package my.rfp;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RfpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfpApplication.class, args);
	}
  
//	@Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();
	    modelMapper.getConfiguration()
	        .setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
