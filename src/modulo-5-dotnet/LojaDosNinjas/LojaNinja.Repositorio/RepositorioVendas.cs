using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\Hedo\Desktop\vendas.txt";
        private static readonly object objetoLock = new object();


        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public List<Pedido> ObterPedidosPorNomeEProduto(string nome, string produto)
        {
            var pedidos = ObterPedidos();
             if (nome != null && produto == null || nome != null && produto =="")
            {
                return pedidos.Where(x => x.NomeCliente.ToLower().Equals(nome.ToLower())).ToList();
            }
             else if (produto != null && nome == null || produto != null && nome == "")
            {
                return pedidos.Where(x => x.NomeProduto.ToLower().Equals(produto.ToLower())).ToList();
            }
            else 
            {
                return pedidos.Where(x => x.NomeCliente.ToLower().Equals(nome.ToLower()) && x.NomeProduto.ToLower().Equals(produto.ToLower())).ToList();
            }
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);              // Pega o último ID da lista gerada a partir do csv
                var idGerado = utlimoId + 1;                                    // adiciona 1 ao ultimo id, para que seja o id do novo produto a ser inserido
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);

                File.AppendAllText(PATH_ARQUIVO, novaLinha);

                pedido.AtualizarId(idGerado);
            }
        }

        public void ExcluirPedido(int id)
        {
            var tempFile = Path.GetTempFileName();
            var linesToKeep = File.ReadLines(PATH_ARQUIVO).Where(l => l.Split(';').First() != id.ToString());

            File.WriteAllLines(tempFile, linesToKeep);

            File.Delete(PATH_ARQUIVO);
            File.Move(tempFile, PATH_ARQUIVO);

        }

        public void EditarPedido(Pedido pedido)
        {

        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }

        

        //public Pedido ConverteLinhaEmPedido(int idParam)
        //{
        //    var linha = File.ReadLines(PATH_ARQUIVO).Where(l => l.Split(';').First() == idParam.ToString());
        //    linha = linha.ToString();
        //    var id = Convert.ToInt32(linha.Split(';')[0]);
        //    var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
        //    var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
        //    var nomeProduto = linha.Split(';')[3];
        //    var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
        //    TipoPagamento tipoPagamento;
        //    Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
        //    var nomeCliente = linha.Split(';')[6];
        //    var cidade = linha.Split(';')[7];
        //    var estado = linha.Split(';')[8];
        //    var urgente = Convert.ToBoolean(linha.Split(';')[9]);

        //    var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
        //    return pedido;
        //}
    }
}
