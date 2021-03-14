package org.jeycode.dtolib.converters;

import javax.annotation.processing.Generated;
import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Car;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Customer.CustomerBuilder;
import org.jeycode.dtolib.entities.Message;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-14T22:15:30+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class GenericMapStructMapperImpl implements GenericMapStructMapper {

    @Override
    public CustomerSimpleDto toSimpleDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerSimpleDto customerSimpleDto = new CustomerSimpleDto();

        customerSimpleDto.setCustomerId( customer.getCustomerId() );
        customerSimpleDto.setName( customer.getName() );
        customerSimpleDto.setSurnames( customer.getSurnames() );
        customerSimpleDto.setNif( customer.getNif() );
        customerSimpleDto.setPurchaseDate( customer.getPurchaseDate() );

        return customerSimpleDto;
    }

    @Override
    public CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerSimpleDto customerSimpleDto = new CustomerSimpleDto();

        customerSimpleDto.setCustomerId( customer.getCustomerId() );
        customerSimpleDto.setName( customer.getName() );
        customerSimpleDto.setSurnames( customer.getSurnames() );
        customerSimpleDto.setNif( customer.getNif() );

        return customerSimpleDto;
    }

    @Override
    public Customer toCustomer(DtoToCreateCustomer dtoToCreateCustomer) {
        if ( dtoToCreateCustomer == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.of();

        customer.name( dtoToCreateCustomer.getName() );
        customer.surnames( dtoToCreateCustomer.getSurnames() );
        customer.nif( dtoToCreateCustomer.getNif() );
        customer.units( dtoToCreateCustomer.getUnits() );
        customer.purchaseDate( dtoToCreateCustomer.getPurchaseDate() );

        return customer.get();
    }

    @Override
    public CustomerComplexDto toCustomerComplexDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerComplexDto customerComplexDto = new CustomerComplexDto();

        customerComplexDto.setPayment( customerCarCarPrice( customer ) );
        customerComplexDto.setCustomerId( customer.getCustomerId() );
        customerComplexDto.setName( customer.getName() );
        customerComplexDto.setSurnames( customer.getSurnames() );
        customerComplexDto.setNif( customer.getNif() );
        customerComplexDto.setPurchaseDate( customer.getPurchaseDate() );

        return customerComplexDto;
    }

    @Override
    public MixDto toMixDto(Customer customer, Message message) {
        if ( customer == null && message == null ) {
            return null;
        }

        MixDto mixDto = new MixDto();

        if ( customer != null ) {
            mixDto.setCarModel( customerCarCarModel( customer ) );
            mixDto.setCarBrand( customerCarCarBrand( customer ) );
            mixDto.setCarPrice( customerCarCarPrice( customer ) );
            mixDto.setCarPower( customerCarCarPower( customer ) );
            mixDto.setCustomerId( customer.getCustomerId() );
            mixDto.setName( customer.getName() );
            mixDto.setSurnames( customer.getSurnames() );
            mixDto.setNif( customer.getNif() );
            mixDto.setPurchaseDate( customer.getPurchaseDate() );
        }
        if ( message != null ) {
            mixDto.setMessage( message );
        }

        return mixDto;
    }

    private float customerCarCarPrice(Customer customer) {
        if ( customer == null ) {
            return 0.0f;
        }
        Car car = customer.getCar();
        if ( car == null ) {
            return 0.0f;
        }
        float carPrice = car.getCarPrice();
        return carPrice;
    }

    private String customerCarCarModel(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Car car = customer.getCar();
        if ( car == null ) {
            return null;
        }
        String carModel = car.getCarModel();
        if ( carModel == null ) {
            return null;
        }
        return carModel;
    }

    private String customerCarCarBrand(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Car car = customer.getCar();
        if ( car == null ) {
            return null;
        }
        String carBrand = car.getCarBrand();
        if ( carBrand == null ) {
            return null;
        }
        return carBrand;
    }

    private int customerCarCarPower(Customer customer) {
        if ( customer == null ) {
            return 0;
        }
        Car car = customer.getCar();
        if ( car == null ) {
            return 0;
        }
        int carPower = car.getCarPower();
        return carPower;
    }
}
