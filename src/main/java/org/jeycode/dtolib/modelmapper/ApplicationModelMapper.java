package org.jeycode.dtolib.modelmapper;

import org.jeycode.constants.DataCustomerHelper;
import org.jeycode.dtolib.converters.impl.GenericModelMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class ApplicationModelMapper
{

      static Gson gsonConverter = new GsonBuilder().setPrettyPrinting()
                                                   .create();

      static GenericModelMapper genericMapper = GenericModelMapper.singleInstance();

      public static void main(String[] args)
      {

            var customer = DataCustomerHelper.customer();
            var message = DataCustomerHelper.message();
            var customerDto = DataCustomerHelper.dtoToCreateCustomer();

            var mapSimple = genericMapper.toSimpleDto(customer);
            System.out.println("Mapeado Simple:\n" + gsonConverter.toJson(mapSimple));

            var mapSimpleSkip = genericMapper.toSimpleDtoSkippingDate(customer);
            System.out.println("Mapeado Simple skipeando:\n" + gsonConverter.toJson(mapSimpleSkip));

            var mapReverse = genericMapper.toCustomer(customerDto);
            System.out.println("Mapeado Reverse:\n" + gsonConverter.toJson(mapReverse));

            var mapComplex = genericMapper.toCustomerComplexDto(customer);
            System.out.println("Mapeado Complex:\n" + gsonConverter.toJson(mapComplex));

            var mapMix = genericMapper.toMixDto(customer,message);
            System.out.println("Mapeado Mix:\n" + gsonConverter.toJson(mapMix));

      }
}
