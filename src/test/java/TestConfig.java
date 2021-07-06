import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"ru.omb.service", "ru.omb.storage"})
@EntityScan(basePackages = "ru.omb.entity")
public class TestConfig {
}
