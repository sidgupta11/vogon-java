package org.zlogic.vogon.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.junit.Test;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;

public class PersistenceConfigurationDiffblueTest {
    @Test
    public void testTransactionManager() {
        PersistenceConfiguration persistenceConfiguration = new PersistenceConfiguration();
        SessionFactoryDelegatingImpl sessionFactoryDelegatingImpl = new SessionFactoryDelegatingImpl(
                new SessionFactoryDelegatingImpl(new SessionFactoryDelegatingImpl(new SessionFactoryDelegatingImpl(null))));
        JpaTransactionManager actualTransactionManagerResult = persistenceConfiguration
                .transactionManager(sessionFactoryDelegatingImpl);
        assertFalse(actualTransactionManagerResult.isValidateExistingTransaction());
        assertFalse(actualTransactionManagerResult.isRollbackOnCommitFailure());
        assertTrue(actualTransactionManagerResult.isNestedTransactionAllowed());
        assertTrue(actualTransactionManagerResult.isGlobalRollbackOnParticipationFailure());
        assertFalse(actualTransactionManagerResult.isFailEarlyOnGlobalRollbackOnly());
        assertEquals(0, actualTransactionManagerResult.getTransactionSynchronization());
        assertSame(sessionFactoryDelegatingImpl, actualTransactionManagerResult.getResourceFactory());
        assertEquals(-1, actualTransactionManagerResult.getDefaultTimeout());
        assertTrue(actualTransactionManagerResult.getJpaDialect() instanceof org.springframework.orm.jpa.DefaultJpaDialect);
    }

    @Test
    public void testExceptionTranslation() {
        PersistenceExceptionTranslationPostProcessor actualExceptionTranslationResult = (new PersistenceConfiguration())
                .exceptionTranslation();
        assertEquals(Integer.MAX_VALUE, actualExceptionTranslationResult.getOrder());
        assertFalse(actualExceptionTranslationResult.isProxyTargetClass());
        assertFalse(actualExceptionTranslationResult.isOptimize());
        assertFalse(actualExceptionTranslationResult.isOpaque());
        assertFalse(actualExceptionTranslationResult.isFrozen());
        assertFalse(actualExceptionTranslationResult.isExposeProxy());
    }

    @Test
    public void testUnloadJDBCDriver() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        (new PersistenceConfiguration()).unloadJDBCDriver();
    }
}

