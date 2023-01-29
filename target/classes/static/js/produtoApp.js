angular.module('produtoApp', []).controller('ProdutoController', function ($scope, $http) {
  $scope.novoitem = 0;
  $scope.produto = {
    id: 0,
    nome: "",
    descricao: "",
    valor: 0,
  }
  $scope.novoitem = false;
  $scope.listarProdutos = function () {
    $http.get("/api/produto/")
      .then(function (response) {
        $scope.produtos = response.data;
        $scope.novoitem = false;
      });
  }
  $scope.removerProduto = function (id) {
    let url = '/api/produto/' + id;
    $http({
      method: "DELETE",
      url: url
    }).then(function (response) {
      $scope.listarProdutos();
    }, function (response) {
      console.log('Erro: ' + response)
    });

  }
  $scope.editarProduto = function (produto) {
    $scope.produto = produto;
    $scope.novoitem = true;
  }
  $scope.listarProdutos();
  $scope.limparForm = function () {
    $scope.produto.id = "";
    $scope.produto.nome = "";
    $scope.produto.descricao = "";
    $scope.produto.valor = 0.0;
  }

  $scope.salvarProduto = function () {
    //let tipo = "POST";
    let tipo = "PUT";
      
      let url = '/api/produto/';
      $http({
        method: tipo,
        url: url,
        data: $scope.produto
      }).then(function (response) {
        $scope.listarProdutos();
      }, function (response) {
        console.log('Erro: ' + response)
      });
    

  }
  $scope.LiberNovo = function () {
    $scope.limparForm();
    $scope.novoitem = true;
    
  }
});