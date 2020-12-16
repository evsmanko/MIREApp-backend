package evgeny.manko.MIREApp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import evgeny.manko.MIREApp.model.Lesson;
import evgeny.manko.MIREApp.repository.LessonRepository;
import evgeny.manko.MIREApp.service.ScheduleUpdateService;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableMongoRepositories("evgeny.manko.MIREApp.repository")
public class MireAppApplication {

	@Autowired
	ScheduleUpdateService scheduleUpdateService;

	private static final Logger log = LoggerFactory.getLogger("MireAppApplication");
	public static void main(String[] args) {
		SpringApplication.run(MireAppApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		scheduleUpdateService.updateFromJson();
	}

}
