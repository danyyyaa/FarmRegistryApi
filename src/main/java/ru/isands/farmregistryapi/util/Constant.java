package ru.isands.farmregistryapi.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

@UtilityClass
public class Constant {
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PAGE_DEFAULT_FROM = "0";
    public static final String PAGE_DEFAULT_SIZE = "30";
    public static final Sort SORT_BY_NAME_DESC = Sort.by(Sort.Direction.DESC, "name");
    public static final Sort SORT_BY_CODE_DESC = Sort.by(Sort.Direction.DESC, "code");
}
