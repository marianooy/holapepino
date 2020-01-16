package holapepino.extentreport;

import cucumber.api.event.*;
import cucumber.runtime.formatter.PluginFactory;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Configuration;

import java.io.File;
import java.io.IOException;

import static java.util.Collections.singletonList;


public class PrettyReports implements EventListener {

    private final File outputDir;
    private final File jsonFile;
    private final EventListener delegateJsonEventListener;

    public PrettyReports() throws IOException {
        this(new File("target" + File.separator + "cucumber"));
    }
    public PrettyReports (final File outputDir) throws IOException {
        this(outputDir, createTempFileDeletedOnExit());
    }
    protected PrettyReports(final File outputDir, final File jsonFile){
        this(outputDir, jsonFile, createJsonEventListener(jsonFile));
    }
    protected PrettyReports(final File outputDir, final File jsonFile, final EventListener delegateJsonEventListener){
        this.outputDir = outputDir;
        this.jsonFile = jsonFile;
        this.delegateJsonEventListener = delegateJsonEventListener;
    }

    protected static File createTempFileDeletedOnExit() throws IOException {
        final File jsonFile = File.createTempFile("cucumber", ".json");
        jsonFile.deleteOnExit();
        return jsonFile;
    }
    protected static EventListener createJsonEventListener(final File jsonFile){
        return (EventListener) new PluginFactory().create(("json:" + jsonFile.getAbsoluteFile()));
    }
    @Override
    public void setEventPublisher(final EventPublisher publisher){
        delegateJsonEventListener.setEventPublisher(publisher);
        publisher.registerHandlerFor(TestRunFinished.class, generatePrettyReport(jsonFile));
    }
    protected EventHandler<TestRunFinished> generatePrettyReport(final File jsonFile) {
        return unused -> generatePrettyReport(jsonFile, outputDir);
    }


    protected static void generatePrettyReport(File jsonFile, final File outputDir) {
        final Configuration configuration = ConfigurationFactory.getConfiguration(outputDir);
        new ReportBuilder(singletonList(jsonFile.getAbsolutePath()), configuration).generateReports();
    }
}
