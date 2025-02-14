<template>
    <div>
        <h1>Lista de Usuários</h1>
        <button @click="carregarUsuarios">Carregar Usuários</button>
        <ul>
            <li v-for="usuario in usuarios" :key="usuario.id">
                <span>{{ usuario.nome }} - {{ usuario.email }}</span>
                <button @click="editarUsuario(usuario.id)">Editar</button>
                <button @click="deletarUsuario(usuario.id)">Excluir</button>
            </li>
        </ul>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import axios from 'axios';

export default {
    computed: {
        ...mapState(['usuarios']),
    },
    methods: {
        ...mapActions(['fetchUsuarios']),
        carregarUsuarios() {
            this.fetchUsuarios();
        },
        editarUsuario(id) {
            // Redireciona para a página de edição de usuário
            this.$router.push(`/usuarios/${id}/editar`);
        },
        deletarUsuario(id) {
            axios.delete(`http://localhost:8080/api/usuarios/${id}`)
                .then(() => {
                    this.fetchUsuarios();  // Recarrega a lista de usuários após a exclusão
                    alert('Usuário excluído com sucesso!');
                })
                .catch(error => {
                    console.error("Erro ao excluir usuário", error);
                    alert('Erro ao excluir usuário');
                });
        }
    }
};
</script>
