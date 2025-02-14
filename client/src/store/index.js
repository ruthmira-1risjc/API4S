import { createStore } from 'vuex';
import axios from 'axios';

export default createStore({
    state: {
        usuarios: []
    },
    mutations: {
        SET_USUARIOS(state, usuarios) {
            state.usuarios = usuarios;
        }
    },
    actions: {
        async fetchUsuarios({ commit }) {
            try {
                const response = await axios.get('/usuarios'); // Faz a requisição ao backend
                commit('SET_USUARIOS', response.data);
            } catch (error) {
                console.error("Erro ao buscar usuários:", error);
            }
        }
    }
});
