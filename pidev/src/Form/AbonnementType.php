<?php

namespace App\Form;
use App\Entity\Abonnement;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Validator\Constraints as Assert;
use App\Repository\OffreRepository;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Validator\Constraints\NotNull;
use Symfony\Component\Validator\Context\ExecutionContextInterface;

class AbonnementType extends AbstractType
{
    private $offreRepository;

    public function __construct(OffreRepository $offreRepository)
    {
        $this->offreRepository = $offreRepository;
    }

    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('typeAb', ChoiceType::class, array(
                'choices' => array(
                    'Standard' => 'Standard',
                    'Premium' => 'Premium',
                    'Premium+' => 'Premium+',
                ),
                'placeholder' => 'Choose a subscription',
                'required' => false,
                'label' => 'Subscription Type',
                 'constraints' => [
        new NotNull(['message' => 'Please choose a subscription type.']),
    ],
            ))
            ->add('dateDebut', DateType::class, [
                'label' => 'Start date',
                'widget' => 'single_text',
                'attr' => [
                    'placeholder' => 'Enter start date',

                ],
                'required' => false,
                'constraints' => [
                    new NotNull(['message' => 'Please choose a start date.']),
                ],
            ])
            ->add('dateFin', DateType::class, [
                'label' => 'End date',
                'widget' => 'single_text',
                'attr' => [
                    'placeholder' => 'Enter end date',
                ],
                'required' => false,
                'constraints' => [
                    new NotNull(['message' => 'Please choose an end date.']),
                ],
            ])
            ->add('prixAb', NumberType::class, [
                'required' => false,
                'label' => 'Subscription Price',
            ])
            ->add('idoffre', ChoiceType::class, [
                'choices' => $this->offreRepository->getChoices(),
                'placeholder' => 'Choose an offer',
                'required' => false,
                'label' => 'Subscription description',
                'constraints' => [
                    new NotNull(['message' => 'Please choose an offer.']),
                ],
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Abonnement::class,
        ]);
    }
}