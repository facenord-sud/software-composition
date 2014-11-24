package ch.unibe.scg.dicto.test;

import ch.unibe.scg.dicto.builder.Rules;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by leo on 24.11.14.
 */
public class DictoSuite extends ParentRunner<Runner> {

    /**
     * The <code>SuiteClasses</code> annotation specifies the classes to be run when a class
     * annotated with <code>@RunWith(Suite.class)</code> is run.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface SuiteClasses {
        /**
         * @return the classes to be run
         */
        public Class<?>[] value();
    }

    /**
     * The <code>SuiteClasses</code> annotation specifies the classes to be run when a class
     * annotated with <code>@RunWith(Suite.class)</code> is run.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface SuiteID {
        /**
         * @return the classes to be run
         */
        public String value();
    }

    /**
     * The <code>SuiteClasses</code> annotation specifies the classes to be run when a class
     * annotated with <code>@RunWith(Suite.class)</code> is run.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface ProjectRoot {
        /**
         * @return the classes to be run
         */
        public String value();
    }

    private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
        SuiteClasses annotation = klass.getAnnotation(SuiteClasses.class);
        if (annotation == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName()));
        }
        return annotation.value();
    }

    private static String getSuiteID(Class<?> klass) throws InitializationError {
        SuiteID annotataion = klass.getAnnotation(SuiteID.class);
        if(annotataion == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteID annotation", klass.getName()));
        }
        return annotataion.value();
    }

    private static String getProjectRoot(Class<?> klass) throws InitializationError {
        SuiteID annotataion = klass.getAnnotation(SuiteID.class);
        if(annotataion == null) {
            throw new InitializationError(String.format("class '%s' must have a ProjectRoot annotation", klass.getName()));
        }
        return annotataion.value();
    }

    private final List<Runner> runners;

    public DictoSuite(Class<?> klass, RunnerBuilder runner) throws InitializationError, IllegalAccessException, InstantiationException, InvocationTargetException {
        super(klass);
        //this.runners = runner.runners(klass, getAnnotatedClasses(klass));
        for(Class aKlass : getAnnotatedClasses(klass)) {
            Object t = aKlass.newInstance();
            for (Method method : aKlass.getMethods()) {
                if (method.isAnnotationPresent(DictoTest.class)) {
                    method.invoke(t);
                    Rules.save();
                }
            }
        }
        ProjectDefinition.setSuiteId(getSuiteID(klass));
        ProjectDefinition.setProjectRoot(getProjectRoot(klass));
        this.runners = runner.runners(klass, new Class[]{RulesParametrizedTest.class});
    }

    @Override
    protected List<Runner> getChildren() {
        return runners;
    }

    @Override
    protected Description describeChild(Runner child) {
        return child.getDescription();
    }

    @Override
    protected void runChild(Runner child, RunNotifier notifier) {
        child.run(notifier);
    }
}

