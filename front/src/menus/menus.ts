const menus: Array<Object> = [
    {
        title: 'Home',
        route: "/",
        icon: 'pi pi-home'
    },
    {
        title: 'About',
        route: "/",
        icon: 'pi pi-info-circle'
    },
    {
        title: 'Contact',
        route: "/login",
        icon: 'pi pi-envelope'
    },
    {
        title: "Favourites",
        icon: 'pi pi-star',
        open: false,
        childrens: [
            {
                title: 'Movies',
                route: '/',
                icon: 'pi pi-plus'
            },
            {
                title: 'Actors',
                icon: 'pi pi-users',
                open: false,
                childrens: [
                    {
                        title: 'Movies',
                        route: '/',
                        icon: 'pi pi-plus'
                    },
                    {
                        title: 'Actors',
                        route: '/login',
                        icon: 'pi pi-users'
                    }
                ]
            }
        ]
    }
];

export default menus;