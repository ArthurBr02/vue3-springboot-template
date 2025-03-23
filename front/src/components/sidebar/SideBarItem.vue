<script>
import { RouterLink } from 'vue-router';

export default {
    props: {
        menu: Object
    }
}
</script>
<template>
    <template v-if="menu.childrens">
        <li class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group cursor-pointer" @click="menu.open = !menu.open">
            <i v-if="menu.icon" :class="menu.icon" class="w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900"></i>
            <span class="ms-3">{{ $t('menu.title.' + menu.title) }}</span>
            <i :class="'pi pi-angle-' + (menu.open ? 'down' : 'up') + ' ms-auto'"></i>
        </li>
        <ul class="p-0" v-if="menu.open">
            <li v-for="child in menu.childrens" :key="child.label" class="pl-4 mt-2">
                <SideBarItem :menu="child" />
            </li>
        </ul>
    </template>
    <template v-else>
        <RouterLink :to="menu.route" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
            <i v-if="menu.icon" :class="menu.icon" class="w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900"></i>
            <span class="ms-3">{{ $t('menu.title.' + menu.title) }}</span>
        </RouterLink>
    </template>
</template>