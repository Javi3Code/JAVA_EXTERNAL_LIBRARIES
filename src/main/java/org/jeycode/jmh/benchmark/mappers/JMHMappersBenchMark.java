package org.jeycode.jmh.benchmark.mappers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.jeycode.constants.DataCustomerHelper;
import org.jeycode.dtolib.converters.impl.GenericBeanmapperMapper;
import org.jeycode.dtolib.converters.impl.GenericMapStructMapper;
import org.jeycode.dtolib.converters.impl.GenericModelMapper;
import org.jeycode.dtolib.converters.impl.GenericSelmaMapper;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.mapstruct.factory.Mappers;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import fr.xebia.extras.selma.Selma;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(warmups = 0, value = 1)
@Warmup(time = 1, timeUnit = TimeUnit.MINUTES, iterations = 1)
@State(Scope.Benchmark)
@Measurement(time = 2, timeUnit = TimeUnit.MINUTES, iterations = 3)
public class JMHMappersBenchMark
{

      @Param({"1","100","10000"})
      int size;

      List<Customer> customers;

      private final GenericModelMapper genericModelMapper = GenericModelMapper.singleInstance();
      private final GenericMapStructMapper genericMapStructMapper = Mappers.getMapper(GenericMapStructMapper.class);
      private final GenericBeanmapperMapper beanmapperMapper = GenericBeanmapperMapper.singleInstance();
      private final GenericSelmaMapper genericSelmaMapper = Selma.getMapper(GenericSelmaMapper.class);

      public static void main(String[] args) throws IOException
      {
//            Main.main(List.of("-rf","json")
//                          .toArray(args));
            var gson = new GsonBuilder().setPrettyPrinting()
                                        .create();
            JMHResult[] result = gson.fromJson(new JsonReader(new FileReader(new File("jmh-result.json"))),JMHResult[].class);
            Comparator<JMHResult> comparator = (res,res2)->
                  {
                        var dataSizeComparation = res.getParams()
                                                     .getSize()
                                                     .compareTo(res2.getParams()
                                                                    .getSize());
                        return dataSizeComparation == 0 ? Double.compare(res.getPrimaryMetric()
                                                                            .getScore(),
                                                                         res2.getPrimaryMetric()
                                                                             .getScore()) :
                              dataSizeComparation;
                  };
            Stream.of(result)
                  .sorted(comparator.reversed())
                  .forEach(res-> System.out.printf("Result(millis): %s | Params: %s | Benchmark: %s%n",res.getPrimaryMetric()
                                                                                                          .getScore(),
                                                   res.getParams()
                                                      .getSize(),
                                                   getClassFrom(res)));

      }

      private static String getClassFrom(JMHResult res)
      {
            String[] classnameSplitted = res.getBenchmark()
                                            .split("\\.");
            return classnameSplitted[classnameSplitted.length - 1];
      }

      @Setup
      public void loadCustomers()
      {
            customers = IntStream.range(0,size)
                                 .mapToObj(num-> DataCustomerHelper.customer())
                                 .collect(Collectors.toUnmodifiableList());
      }

      @Benchmark
      public boolean mapStruct()
      {
            recollectWith(customer-> genericMapStructMapper.toMixDto(customer,DataCustomerHelper.message()));
            return true;
      }

      @Benchmark
      public boolean mapModelMapper()
      {
            recollectWith(customer-> genericModelMapper.toMixDto(customer,DataCustomerHelper.message()));
            return true;
      }

      @Benchmark
      public boolean mapSelma()
      {
            recollectWith(customer-> genericSelmaMapper.toMixDto(customer,DataCustomerHelper.message()));
            return true;
      }

      @Benchmark
      public boolean mapBeanmapper()
      {
            recollectWith(customer-> beanmapperMapper.toMixDto(customer,DataCustomerHelper.message()));
            return true;
      }

      private void recollectWith(Function<Customer,MixDto> mapFunction)
      {
            customers.stream()
                     .map(mapFunction::apply)
                     .collect(Collectors.toList());
      }

}
