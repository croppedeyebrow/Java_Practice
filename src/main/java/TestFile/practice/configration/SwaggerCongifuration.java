package TestFile.practice.configration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SwaggerCongifuration {

    @Bean
      public OpenAPI openAPI() {
        return new OpenAPI()
              .components(new Components())
              .info(apiinfo());
    }

    private Info apiinfo() {
        return new Info()
                .title("Spring Boot Open API Test with Swagger")
                .description("설명 부분")
                .version("1.0.0");
    }
}