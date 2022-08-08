package MavProject.Basic;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import MavProject.Basic;
public class App

{

  public static void main( String[] args )

  {

    ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");

    AbcSchool ob=(AbcSchool)ctx.getBean("a1");

    ob.saveValue();

  }

}

