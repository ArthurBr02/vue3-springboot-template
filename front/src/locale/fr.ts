export default {
    toast: {
        error: 'Erreur',
        success: 'Succès',
        info: 'Info',
        warning: 'Attention',
        logout: 'Déconnexion',
        messages: {
            register: {
                success: 'Inscription réussie',
                error: 'Erreur lors de l\'inscription',
                emailAlreadyUsed: 'Email déjà utilisé'
            },
            login: {
                success: 'Connexion réussie',
                error: 'Erreur lors de la connexion'
            },
            password: {
                notMatching: 'Les mots de passe ne correspondent pas'
            },
            form: {
                invalid: 'Formulaire invalide'
            },
            resetPasswordEmail: {
                success: 'Email de réinitialisation envoyé',
                error: 'Erreur lors de l\'envoi de l\'email de réinitialisation'
            },
            settingsResetPasswordEmail: {
                success: 'Email de réinitialisation envoyé. Consultez votre boîte de réception pour réinitialiser votre mot de passe',
                error: 'Erreur lors de l\'envoi de l\'email de réinitialisation'
            },
            resetPassword: {
                success: 'Mot de passe réinitialisé',
                error: 'Erreur lors de la réinitialisation du mot de passe'
            },
            sidebar: {
                logout: 'Déconnexion réussie'
            },
            settingsUserUpdate: {
                success: 'Utilisateur mis à jour',
                emailAlreadyUsed: 'Email déjà utilisé',
                error: 'Erreur lors de la mise à jour de l\'utilisateur'
            },
            settingsProfilePictureUpload: {
                success: 'Photo de profil envoyée',
                error: 'Erreur lors de l\'envoi de la photo de profil',
                noFile: 'Aucun fichier sélectionné'
            }
        }
    },
    login: {
        title: 'Connexion',
        email: 'Email',
        password: 'Mot de passe',
        submit: 'Se connecter',
        forgot: 'Mot de passe oublié',
        register: 'Créer un compte'
    },
    register: {
        title: 'Inscription',
        email: 'Email',
        password: 'Mot de passe',
        submit: 'S\'inscrire',
        firstName: 'Prénom',
        lastName: 'Nom',
        confirmPassword: 'Confirmer le mot de passe',
        locale: 'Langue',
    },
    password: {
        prompt: 'Mot de passe',
        weak: 'Faible',
        average: 'Moyen',
        strong: 'Fort',
    },
    resetPassword: {
        title: 'Réinitialiser le mot de passe',
        email: 'Email',
        submit: 'Envoyer',
        back: 'Retour',
        description: 'Entrez votre adresse email pour recevoir un lien de réinitialisation de mot de passe.',
        description_2: 'Entrez deux fois votre nouveau mot de passe pour le confirmer.',
        newPassword: 'Nouveau mot de passe',
        confirmPassword: 'Confirmer le mot de passe'
    },
    dashboard: {
        title: 'Tableau de bord',
        welcome: 'Bienvenue'
    },
    sidebar: {
        logout: 'Déconnexion',
        account: 'Compte',
    },
    settings: {
        title: 'Paramètres',
        menu: {
            general: 'Général',
            security: 'Sécurité',
            notifications: 'Notifications',
            appearance: 'Apparence',
            language: 'Langue',
            about: 'À propos',
            user: 'Utilisateur',
        },
        user: {
            title: 'Utilisateur',
            firstName: 'Prénom',
            lastName: 'Nom',
            email: 'Email',
            locale: 'Langue',
            submit: 'Enregistrer',
            changePassword: 'Changer le mot de passe',
            askForResetPwdMail: 'Demander un email de réinitialisation de mot de passe',
            profilePicture: 'Photo de profil',
            upload: 'Envoyer',
        }
    }
}