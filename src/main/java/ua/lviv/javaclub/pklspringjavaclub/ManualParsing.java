package ua.lviv.javaclub.pklspringjavaclub;

import org.pkl.config.java.Config;
import org.pkl.config.java.ConfigEvaluator;
import org.pkl.core.ModuleSource;
import ua.lviv.JavaClub;

public class ManualParsing {

    public static void main(String[] args) {
        try (ConfigEvaluator configEvaluator = ConfigEvaluator.preconfigured()) {
            Config config = configEvaluator.evaluate(ModuleSource.modulePath("/pkl/JavaClub.pkl"));
            JavaClub javaClub = config.as(JavaClub.class);
            javaClub.meetings.forEach(meeting ->  {
                System.out.println("meeting.week = " + meeting.week);
                System.out.println("meeting.speaker = " + meeting.speaker);
            });
        }
    }

}
