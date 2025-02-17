<template>
    <form @submit.prevent="submitForm">
      <div>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" v-model="usuario.nome" required />
      </div>
  
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="usuario.email" required />
      </div>
  
      <button type="submit">Salvar Usuário</button>
    </form>
  </template>
  
  <script>
  export default {
    props: {
      usuarioInicial: {
        type: Object,
        default: () => ({ nome: "", email: "" }),
      },
    },
    data() {
      return {
        usuario: { ...this.usuarioInicial },
      };
    },
    methods: {
      submitForm() {
        this.$emit("salvar", this.usuario);
        this.usuario = { nome: "", email: "" }; // Resetando o formulário
      },
    },
  };
  </script>
  
  <style scoped>
  form {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 10px;
  }
  
  input {
    padding: 8px;
    width: 250px;
  }
  
  button {
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
  </style>
  