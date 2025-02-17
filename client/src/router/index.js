import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import UsuariosView from '../views/UsuariosView.vue';
import CriarUsuarioView from '../views/CriarUsuarioView.vue';

const routes = [
  { path: '/', name: 'Home', component: HomeView },
  { path: '/usuarios', name: 'Usuarios', component: UsuariosView },
  { path: '/criar-usuario', name: 'CriarUsuario', component: CriarUsuarioView }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
