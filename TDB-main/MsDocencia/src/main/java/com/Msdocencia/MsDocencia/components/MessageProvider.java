package TDB.MsControlAcademico.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:messages.properties")
public class MessageProvider {

    public MessageProvider() {

    }

    @Value("${error.message.generic}")
        private String genericErrorMessage;

        @Value("${error.message.invalid.request}")
        private String invalidRequestErrorMessage;

        @Value("${deleted.message}")
        private String succesfullyDeletedMessage;

        @Value("${update.message}")
        private String updatemessage;
        
        public String getUpdateMessage() {
            return updatemessage;
        }


        public String getGenericErrorMessage() {
            return genericErrorMessage;
        }

        public String getInvalidRequestErrorMessage() {
            return invalidRequestErrorMessage;
        }

    public String getSuccesfullyDeletedMessage() {
        return succesfullyDeletedMessage;
    }
}

