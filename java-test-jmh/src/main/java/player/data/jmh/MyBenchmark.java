
package player.data.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import player.data.jmh.str.StringBuilderTest;

public class MyBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(StringBuilderTest.class.getSimpleName())
                .output("/root/Downloads/jmh_benchmark.log").forks(2).build();
        new Runner(options).run();
    }

}
