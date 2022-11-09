package org.quarkus.extension.anonymiser.mask;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class DeploymentBeanCreator {


    @BuildStep
    AdditionalBeanBuildItem produce() {
        return AdditionalBeanBuildItem.builder()
                .setUnremovable()
                .addBeanClasses(
                        MaskAnonymiser.class
                )
                .build();
    }

}
