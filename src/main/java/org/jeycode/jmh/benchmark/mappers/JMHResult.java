package org.jeycode.jmh.benchmark.mappers;

import lombok.Data;

@Data
public class JMHResult
{
      private String benchmark;
      private JMHParams params;
      private JMHMetric primaryMetric;
}
