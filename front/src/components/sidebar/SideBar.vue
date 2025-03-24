<script>
import { Drawer, Button, Avatar } from 'primevue';
import menus from '../../menus/menus';
import { getUser } from '../../mixins/user';
import SideBarItem from './SideBarItem.vue';

export default {
    components: {
        Drawer,
        Button,
        Avatar,
        SideBarItem
    },
    data() {
        return {
            visible: false,
            menus: menus,
            currentUser: null
        }
    },
    mounted() {
        this.currentUser = this.getUser();
    },
    methods: {
        getUser,
        logout() {
            this.visible = false;
            localStorage.removeItem('token');
            this.$router.push('/login');
            this.$toast.add({ severity: 'success', summary: 'Success', detail: this.$t('toast.messages.sidebar.logout'), life: 3000 });
        },
        goToUserSettings() {
            this.visible = false;
            this.$router.push('/settings/user');
        }
    },
    computed: {
        display() {
            return this.$route.meta.noSidebar !== undefined ? !this.$route.meta.noSidebar : true;
        }
    },
}
</script>
<template>
    <Button class="absolute" v-show="display && !visible" icon="pi pi-bars" @click="visible = true" />
    <div v-if="display" class="card w-full" style="z-index: 1001;">
        <Drawer v-model:visible="visible">
            <template #header>
                <div class="flex items-center gap-2">
                    <Avatar image="/favicon.ico" shape="circle" />
                    <span class="font-bold">{{  currentUser?.firstName + " " + currentUser?.lastName }}</span>
                </div>
            </template>
            <div>
                <ul class="p-0">
                    <li v-for="menu in menus" :key="menu.label" class="mb-2">
                        <SideBarItem :menu="menu" />
                    </li>
                </ul>
            </div>
            <template #footer>
                <div class="flex items-center gap-2">
                    <Button @click="goToUserSettings" :label="$t('sidebar.account')" icon="pi pi-user" class="flex-auto" outlined></Button>
                    <Button @click="logout" :label="$t('sidebar.logout')" icon="pi pi-sign-out" class="flex-auto" severity="danger" text></Button>
                </div>
            </template>
        </Drawer>
   </div>
</template>
<style>
.absolute {
    position: absolute !important;
    z-index: 1000;
    top: 15px;
    left: 15px;
}
</style>