import { email } from "@vuelidate/validators";

export default {
    toast: {
        error: 'Error',
        success: 'Success',
        info: 'Info',
        warning: 'Warning',
        logout: 'Logout',
        messages: {
            register: {
                success: 'Registration successful',
                error: 'Error during registration'
            },
            login: {
                success: 'Login successful',
                error: 'Error during login'
            },
            password: {
                notMatching: 'Passwords do not match'
            },
            form: {
                invalid: 'Invalid form'
            },
            resetPassword: {
                success: 'Reset email sent',
                error: 'Error during reset email sending'
            },
            settingsResetPasswordEmail: {
                success: 'Reset email sent. Check your inbox to reset your password',
                error: 'Error during reset email sending'
            },
            sidebar: {
                logout: 'Logout successful'
            }
        }
    },
    login: {
        title: 'Login',
        email: 'Email',
        password: 'Password',
        submit: 'Login',
        forgot: 'Forgot password',
        register: 'Create an account'
    },
    register: {
        title: 'Register',
        email: 'Email',
        password: 'Password',
        submit: 'Register',
        firstName: 'First name',
        lastName: 'Last name',
        confirmPassword: 'Confirm password',
        locale: 'Language'
    },
    password: {
        prompt: 'Password',
        weak: 'Weak',
        average: 'Average',
        strong: 'Strong',
    },
    resetPassword: {
        title: 'Reset password',
        email: 'Email',
        submit: 'Send',
        back: 'Back',
        description: 'Enter your email address to receive a password reset link.',
        description_2: 'Enter your new password twice to confirm it.',
        newPassword: 'New password',
        confirmPassword: 'Confirm password'
    },
    dashboard: {
        title: 'Dashboard',
        welcome: 'Welcome',
    },
    sidebar: {
        logout: 'Logout',
        account: 'Account',
    },
    settings: {
        title: 'Settings',
        menu: {
            general: 'General',
            security: 'Security',
            notifications: 'Notifications',
            appearance: 'Appearance',
            language: 'Language',
            about: 'About',
            user: 'User',
        },
        user: {
            title: 'User',
            firstName: 'First name',
            lastName: 'Last name',
            email: 'Email',
            locale: 'Language',
            password: 'Password',
            newPassword: 'New password',
            confirmPassword: 'Confirm password',
            submit: 'Save',
            changePassword: 'Change password',
            askForResetPwdMail: 'Ask for a reset password email'
        }
    },
}