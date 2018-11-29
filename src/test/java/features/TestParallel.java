package features;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

@CucumberOptions(tags = {"~@ignore"})
public class TestParallel {

    private final static String PASTA_RELATORIO = "target" + File.separator + "surefire-reports";

    @Test
    public void testParallel() {
        KarateStats stats = CucumberRunner.parallel(getClass(), 5, "target/surefire-reports");
        geraRelatorio();
        assertTrue("scenarios failed", stats.getFailCount() == 0);
    }

    private static void geraRelatorio() {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(PASTA_RELATORIO), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        for (File file : jsonFiles) {
            jsonPaths.add(file.getAbsolutePath());
        }
        Configuration config = new Configuration(new File("target"), "Convênios");
        config.isParallelTesting();
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
    
}