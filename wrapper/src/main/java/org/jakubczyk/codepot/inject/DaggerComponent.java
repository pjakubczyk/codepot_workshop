package org.jakubczyk.codepot.inject;

import org.jakubczyk.codepot.MediaProjectionManagerWrapper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaggerModule.class})
public interface DaggerComponent {

    final class Initializer {

        public static DaggerComponent init(DaggerModule daggerModule) {
            return DaggerDaggerComponent.builder()
//                    .systemServicesModule(new SystemServicesModule(app))
                    .daggerModule(daggerModule)
                    .build();
        }
    }

    MediaProjectionManagerWrapper getMediaProjectionManagerWrapper();

}
