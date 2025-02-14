import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios';

// Configurando a URL base do backend
axios.defaults.baseURL = 'http://localhost:8080/api'; // Altere para a URL do seu backend

createApp(App)
    .use(router)
    .use(store)
    .mount('#app');
