<template>
    <div class="home">
      <h1>Bem-vindo!</h1>
      <p>Essa é a página inicial da aplicação.</p>
  
      <router-link to="/usuarios">
        <button>Ver Usuários</button>
      </router-link>
  
      <router-link to="/criar-usuario">
        <button class="criar">Criar Usuário</button>
      </router-link>
    </div>
  </template>
  
  <style scoped>
  .home {
    text-align: center;
    margin-top: 50px;
  }
  
  button {
    margin: 10px;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 5px;
  }
  
  button:hover {
    background-color: #369f75;
  }
  
  .criar {
    background-color: #ffcc00;
  }
  
  .criar:hover {
    background-color: #e6b800;
  }
  </style>
  