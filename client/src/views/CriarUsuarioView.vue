<template>
  <div class="container">
    <h1>Criar Novo Usuário</h1>

    <UsuarioForm @salvar="criarUsuario" />

    <router-link to="/">
      <button class="voltar">Voltar para Home</button>
    </router-link>
  </div>
</template>

<script>
import UsuarioForm from "@/components/UsuarioForm.vue";

export default {
  components: {
    UsuarioForm,
  },
  methods: {
    criarUsuario(usuario) {
      alert(`Usuário criado: ${usuario.nome} - ${usuario.email}`);
    },
  },
};
</script>

<style scoped>
.container {
  text-align: center;
  margin-top: 50px;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  background-color: #ff6b6b;
  color: white;
  border: none;
  border-radius: 5px;
}

button:hover {
  background-color: #e63946;
}
</style>
