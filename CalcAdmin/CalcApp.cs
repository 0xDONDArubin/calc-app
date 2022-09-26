using System;
using System.Collections.Generic;
using System.Text;

namespace CalcAdmin
{
    public class CalcApp
    {
        public double Sum(double a, double b)
        {
            return a + b;
        }

        public double Sub(double a, double b)
        {
            return a - b;
        }

        public double Mult(double a, double b)
        {
            return a * b;
        } 

        public double Div(double a, double b)
        {
            if (b == 0) throw new ArgumentException("На ноль делить нельзя!");
            return a / b;
        }

        /*public double SumNegativeNumbers(double a, double b)
        {
            if (a >= 0) throw new ArgumentException("111");
            return a + b;
        }*/
    }
}
