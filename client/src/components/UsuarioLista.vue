<!-- filepath: /C:/Users/ruth.silva/Desktop/API4S/client/src/components/UsuarioLista.vue -->
<template>
  <div>
    <h1>Lista de Usuários</h1>
    <ul>
      <li v-for="user in users" :key="user.id">{{ user.nome }} - {{ user.email }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'UsuarioLista',
  data() {
    return {
      users: [
        { id: 1, nome: 'Usuário 1', email: 'usuario1@example.com' },
        { id: 2, nome: 'Usuário 2', email: 'usuario2@example.com' },
        { id: 3, nome: 'Usuário 3', email: 'usuario3@example.com' }
      ]
    };
  }
};
</script>