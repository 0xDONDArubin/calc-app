using Microsoft.VisualStudio.TestTools.UnitTesting;
using CalcAdmin;
using System;

namespace CalcAdminTests
{
    [TestClass]
    public class CalcAppTests
    {
        [TestMethod]
        public void SumTest()
        {
            var a = 7;
            var b = 6;
            var calc = new CalcApp();

            var res = calc.Sum(a, b);

            Assert.IsTrue(res == a + b);
        }

        [TestMethod]
        public void SubTest()
        {
            double a = 7;
            double b = 6;
            var calc = new CalcApp();

            double res = calc.Sub(a, b);

            Assert.IsTrue(res == a - b);
        }

        [TestMethod]
        public void MultTest()
        {
            double a = 7;
            double b = 6;
            var calc = new CalcApp();

            double res = calc.Mult(a, b);

            Assert.IsTrue(res == a * b);
        }

        [TestMethod]
        public void DivTest()
        {
            double a = 15;
            double b = 3;
            var calc = new CalcApp();

            double res = calc.Div(a, b);

            Assert.IsTrue(res == a / b);
        }



        /*[TestMethod]
        public void SumNegativeNumbersTest()
        {
            double a = -7;
            double b = -6;
            var calc = new CalcApp();

            double res = calc.SumNegativeNumbers(a, b);

            Assert.IsTrue(res == a + b);
        }

        [TestMethod]
        public void SumNegativeNumbersPositiveTest()
        {
            double a = 7;
            double b = 6;
            var calc = new CalcApp();

            Assert.ThrowsException<ArgumentException>(() => calc.SumNegativeNumbers(a, b));
        }*/
    }
}
