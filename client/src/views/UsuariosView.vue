<!-- filepath: /C:/Users/ruth.silva/Desktop/API4S/client/src/views/UsuariosView.vue -->
<template>
  <div>
    <UsuarioLista />
  </div>

  <router-link to="/">
    <button class="voltar">Voltar para Home</button>
  </router-link>

</template>

<script>
import UsuarioLista from '../components/UsuarioLista.vue';

export default {
  name: 'UsuariosView',
  components: {
    UsuarioLista
  }
};
</script>