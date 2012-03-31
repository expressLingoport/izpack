package com.izforge.izpack.test;

import java.util.Properties;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoException;

import com.izforge.izpack.api.data.AutomatedInstallData;
import com.izforge.izpack.api.exception.ContainerException;
import com.izforge.izpack.api.rules.RulesEngine;
import com.izforge.izpack.api.substitutor.VariableSubstitutor;
import com.izforge.izpack.core.container.AbstractContainer;
import com.izforge.izpack.core.rules.ConditionContainer;
import com.izforge.izpack.core.rules.RulesEngineImpl;
import com.izforge.izpack.core.substitutor.VariableSubstitutorImpl;
import com.izforge.izpack.installer.data.GUIInstallData;
import com.izforge.izpack.merge.resolve.MergeableResolver;

/**
 * Container for condition tests.
 *
 * @author Anthonin Bonnefoy
 */
public class TestConditionContainer extends AbstractContainer
{

    /**
     * Constructs a <tt>TestConditionContainer</tt>.
     *
     * @throws ContainerException if initialisation fails
     */
    public TestConditionContainer()
    {
        initialise();
    }

    /**
     * Invoked by {@link #initialise} to fill the container.
     *
     * @param container the underlying container
     * @throws ContainerException if initialisation fails
     * @throws PicoException      for any PicoContainer error
     */
    @Override
    protected void fillContainer(MutablePicoContainer container)
    {
        addComponent(AutomatedInstallData.class, GUIInstallData.class);
        addComponent(RulesEngine.class, RulesEngineImpl.class);
        addComponent(VariableSubstitutor.class, VariableSubstitutorImpl.class);
        addComponent(MutablePicoContainer.class, container);
        addComponent(MergeableResolver.class);
        addComponent(Properties.class);
        addComponent(ConditionContainer.class);
        addComponent(AbstractContainer.class, this);
    }
}
