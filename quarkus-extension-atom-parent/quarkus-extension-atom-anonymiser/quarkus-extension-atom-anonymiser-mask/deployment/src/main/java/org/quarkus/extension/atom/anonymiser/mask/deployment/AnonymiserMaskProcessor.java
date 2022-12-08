package org.quarkus.extension.atom.anonymiser.mask.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.quarkus.extension.atom.anonymiser.mask.MaskAnonymiser;

public class AnonymiserMaskProcessor {

    private static final String FEATURE = "anonymiser-mask";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

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
