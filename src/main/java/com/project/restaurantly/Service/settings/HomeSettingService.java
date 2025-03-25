package com.project.restaurantly.Service.settings;

import com.project.restaurantly.Entity.settings.Home_settings;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.repository.settings.HomeSettingRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeSettingService {
    HomeSettingRepository homeRespository;

    public Home_settings create(Home_settings request) {
        return homeRespository.save(request);
    }

    public List<Home_settings> getAll(String belong){
        return homeRespository.findBySection(belong)
                .stream()
                .toList();
    }

    public Home_settings get(long id){
        return homeRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.HOME_SETTING_NOT_EXISTED));
    }

    public Home_settings update(Home_settings request, long id){
        Home_settings home_settings = homeRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.HOME_SETTING_NOT_EXISTED));

        Home_settings.builder().data(request.getData()).section(request.getSection());

        return homeRespository.save(home_settings);
    }

    public void delete(long id){
        Home_settings home = homeRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.HOME_SETTING_NOT_EXISTED));
    }
}
