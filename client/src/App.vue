<script setup>
import { defineComponent } from 'vue';
</script>

<template>
  <div>
    <h1>Bem-vindo à Página Inicial!</h1>
    <p>Esta é a página inicial do nosso projeto.</p>

    <div>
      <a href="https://vite.dev" target="_blank">
        <img src="/vite.svg" class="logo" alt="Vite logo" />
      </a>
      <a href="https://vuejs.org/" target="_blank">
        <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
      </a>
    </div>

    <!-- Componente HelloWorld -->
    <HelloWorld msg="Vite + Vue" />

    <!-- Aqui será renderizada a página de acordo com a rota -->
    <router-view></router-view> <!-- Este é o espaço para as rotas internas -->
  </div>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
