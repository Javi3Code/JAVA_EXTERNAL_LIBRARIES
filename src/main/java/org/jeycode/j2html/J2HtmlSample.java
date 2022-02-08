package org.jeycode.j2html;

import static j2html.TagCreator.article;
import static j2html.TagCreator.body;
import static j2html.TagCreator.button;
import static j2html.TagCreator.each;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.h3;
import static j2html.TagCreator.head;
import static j2html.TagCreator.header;
import static j2html.TagCreator.html;
import static j2html.TagCreator.img;
import static j2html.TagCreator.li;
import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.p;
import static j2html.TagCreator.script;
import static j2html.TagCreator.section;
import static j2html.TagCreator.span;
import static j2html.TagCreator.text;
import static j2html.TagCreator.title;
import static j2html.TagCreator.ul;
import static j2html.rendering.FlatHtml.into;
import static org.jeycode.datagenerator.constants.DataFakes.getSetOfFakeDataoOf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jeycode.datagenerator.model.Employee;

import j2html.tags.DomContent;
public class J2HtmlSample
{

      public static void main(String[] args) throws IOException
      {
            var data = getSetOfFakeDataoOf(50);
            var streamDomEmployees= data.stream().map(J2HtmlSample::cardOf);     
            var html = html(
                            head(
                                 meta().attr("charset","UTF-8"),
                                 title("Mi primer HTML con J2Html")
                                 ),
                            body(
                                 header(h1("Tabla empleados"),p("Lo q sea"))
                                       .withId("section-header"),
                                 button("Show Data"),
                                 section(
                                         section()
                                               .withId("employees-cards")
                                               .condWith(!data.isEmpty(),each(streamDomEmployees))
                                         )
                                       .withId("employees-view")
                                       .withStyle("display:none"),
                                 script().withSrc("J2Html.js"),
                                 link().attr("rel","stylesheet").attr("href","J2Html.css")
                                 )
                            );
            
//            System.out.println(html.renderFormatted());
            
            try(var out = new FileWriter(new File("J2Html.html")))
            {
                  html.render(into(out));
            }
      }

      
      private static DomContent cardOf(Employee emp)
      {
            return article(
                           h2(nameFormatted(emp)),
                           header(
                               span("ID: "+emp.getEmployeeNumber())
                                     .withStyle("margin-right: 4px")
                                     .isContenteditable(),
                               img().withSrc("snoop-dog.png")
                               ).attr("data-nif",emp.getNIF()),
                           section(
                                   h3("Información"),
                                   ul(
                                     li(span("Edad: ").withStyle("margin-right: 4px"),text(emp.getAge()+"")),  
                                     li(span("Salario: ").withStyle("margin-right: 4px"),text(emp.getSalary()+"")),  
                                     li(span("Categoría: ").withStyle("margin-right: 4px"),text(emp.getCategory()))  
                                      ).isDraggable()
                                   ).withClass("info-section")
                           ).withClass("employee-card");
      }
      
      private static String nameFormatted(Employee employee)
      {
            return String.format("%s, %s",employee.getSurnames(),employee.getName());
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
