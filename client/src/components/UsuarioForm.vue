<template>
    <div>
        <h2>{{ usuario.id ? 'Editar' : 'Cadastrar' }} Usuário</h2>
        <form @submit.prevent="salvarUsuario">
            <div>
                <label for="nome">Nome</label>
                <input type="text" id="nome" v-model="usuario.nome" required />
            </div>
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" v-model="usuario.email" required />
            </div>
            <button type="submit">{{ usuario.id ? 'Salvar Alterações' : 'Cadastrar' }}</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            usuario: {
                id: null,
                nome: '',
                email: ''
            }
        };
    },
    methods: {
        salvarUsuario() {
            if (this.usuario.id) {
                axios.put(`http://localhost:8080/api/usuarios/${this.usuario.id}`, this.usuario)
                    .then(() => {
                        this.$router.push('/usuarios');
                    });
            } else {
                axios.post('http://localhost:8080/api/usuarios', this.usuario)
                    .then(() => {
                        this.$router.push('/usuarios');
                    });
            }
        }
    }
};
</script>
