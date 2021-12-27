package org.jeycode.helpers;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LibGenericHelper
{

      public static Faker FAKER_INSTANCE = Faker.instance(Locale.forLanguageTag("es"));
      public static Gson GSON_CONVERTER = new GsonBuilder().setPrettyPrinting()
                                                           .create();
      public static final RandomService UID_GENERATOR = FAKER_INSTANCE.random();

}
