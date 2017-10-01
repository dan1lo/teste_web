/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var tabela = document.querySelector("table");

tabela.addEventListener("dblclick", function(event){

  var alvoEvento = event.target;
  var paiEvento = alvoEvento.parentNode;
  console.log(paiEvento);
  var nome = paiEvento.getElementsByClassName("td-nome")[0].textContent;
  var id = paiEvento.getElementsByClassName("td-id")[0].textContent;
  var senha = paiEvento.getElementsByClassName("td-senha")[0].textContent;
  var nivel = paiEvento.getElementsByClassName("td-nivel")[0].textContent;
    document.querySelector(".ipt-nome").value = nome;
    document.querySelector(".ipt-id").value = id;
    document.querySelector(".ipt-senha").value = senha;
    document.querySelector(".ipt-nivel").value = nivel;
});

