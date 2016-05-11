using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {

                Console.WriteLine("Digite um número:");
                var numero = Console.ReadLine();

                var numeroConvertido = Convert.ToInt32(numero);

                if (numeroConvertido == 13)
                    throw new ArgumentException("Você digitou o número do azar");

                Console.WriteLine("O número convertido é: " + numeroConvertido);

            } 
            catch (FormatException ex)
            {
                Console.WriteLine("Você deve digitar um número!");
            }
            catch (OverflowException ex)
            {
                Console.WriteLine("O número deve estar no intervalo de -243683648 e 243683648");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            Console.ReadKey();
        }
    }
}
