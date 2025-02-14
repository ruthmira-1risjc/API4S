import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue'; // Página inicial
import UsuariosLista from '../components/UsuarioLista.vue'; // Página de Lista de Usuários
import UsuariosForm from '../components/UsuarioForm.vue'; // Página de Formulário de Usuário

const routes = [
  {
    path: '/',
    component: Home, // Página inicial
    children: [
      {
        path: 'usuarios',
        component: UsuariosLista, // Lista de Usuários
      },
      {
        path: 'usuarios/form',
        component: UsuariosForm, // Formulário de Usuário
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
