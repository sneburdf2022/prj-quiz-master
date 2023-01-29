angular.module('produtoApp', []).controller('QuizController', function ($scope, $http) {
  $scope.novoItem = false;
  $scope.listaQuiz = [];
  $scope.msg = "";
  $scope.quiz = {
    id: 0,
    pergunta: "",
    respostas: [],
    correta: null
  }
  $scope.listarQuiz = function () {
    $http.get("/api/quiz/")
      .then(function (response) {
        console.log(response.data);
        $scope.listaQuiz = response.data;
        $scope.novoItem = false;
      });
  }
  $scope.limparAlerta = function () {
    $scope.msg = "";
    document.querySelector("#alerta").innerHTML = "";
    document.querySelector("#alerta").classList.remove('alert-danger');
    document.querySelector("#alerta").classList.remove('alert-success');
  }
  $scope.editarQuiz = function (x) {
    $scope.quiz = x;
    $scope.novoItem = true;
  }
  $scope.cadastrarNovo = function(){
    $scope.novoItem = true;
  }
  $scope.verificaOpcaoRepetida = function (quiz) {    
    if (quiz.respostas[0] == quiz.respostas[1] || quiz.respostas[0] == quiz.respostas[2] || quiz.respostas[0] == quiz.respostas[3]
      || quiz.respostas[1] == quiz.respostas[2] || quiz.respostas[1] == quiz.respostas[3] || quiz.respostas[2] == quiz.respostas[3]) {
      return true;
    }
    return false;
  }
  
  $scope.gravarQuiz = function () {
    var itemLocal = $scope.quiz;
    $scope.limparAlerta();
    let alerta = document.querySelector("#alerta");
    if ($scope.verificaOpcaoRepetida(itemLocal)) {
      $scope.msg = "Existe uma opção repetida!<br>";
    }else{
      $scope.msg = "";
    }

    if ($scope.msg != "") {
      alerta.innerHTML = $scope.msg;
      alerta.classList.add("alert-danger");
      $timeout(function() { $scope.verificaOpcaoRepetida();}, 5000);
      return;
    } else {

      let url = '/api/quiz/';
      let tipo = "POST";
      if ($scope.quiz.id > 0) {
        tipo = "PUT";
      }
      $http({
        method: tipo,
        url: url,
        data: $scope.quiz
      }).then(function (response) {
        $scope.listarQuiz();
      }, function (response) {
        $scope.listarQuiz();
        console.log('Erro: ' + response)
      });
      if (itemLocal.id > 0) {
        alerta.innerHTML = "Novo item do quiz adicionado!";
      } else {
        alerta.innerHTML = "Pergunta atualzada!";        
      }
      alerta.classList.remove("alert-danger");
      alerta.classList.add("alert-success");
    }

  }
  $scope.limparForm = function () {
    $scope.quiz = null;
    $scope.limparAlerta();
  }
  $scope.removerQuiz = function (id) {
    let url = '/api/quiz/' + id;
    $http({
      method: "DELETE",
      url: url
    }).then(function (response) {
      $scope.listarQuiz();
    }, function (response) {
      $scope.listarQuiz();
      console.log('Erro: ' + response)
    });
  }
  $scope.listarQuiz();
});